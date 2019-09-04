package com.example.student.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.student.project.dao.DataCountDao;
import com.example.student.project.dao.IAgentShopDao;
import com.example.student.project.dao.AuthorDao;
import com.example.student.project.dao.IVideoShopDao;
import com.example.student.project.domain.Author;
import com.example.student.project.domain.DataCount;
import com.example.student.util.RedisUtilCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class DataCountBackGround {
    @Resource
    private DataCountDao dataCountDao;
    @Resource
    private AuthorDao authorDao;
    @Resource
    private IAgentShopDao agentShopDao;
    @Resource
    private IVideoShopDao videoShopDao;
    @Resource
    private RedisUtilCustom redisUtilCustom;
    //用户喜爱视频列表分页
    private static final String USER_LIKE_VIDEO_ID="user_like_video_id_";
    //用户是否喜爱视频
    private static  final String USER_IS_LIKE_VIDEO_ID="user_is_like_video_id_";
    //视频喜爱数
    private static final String VIDEO_LIKE_KEY="video_like_key";
    //视频评论数
    private static final String VIDEO_COMMENT_KEY="video_comment_key";
    //视频分享数
    private static final String VIDEO_SHARE_KEY="video_share_key";
    //关注作者列表
    private static final String ATTENTION_AUTHOR_USER_ID="attention_author_user_id_";
    //是否关注作者用户id
    private static final String ATTENTION_IS_AUTHOR_USER_ID="attention_is_author_user_id_";
    //用户收藏视频列表 key是用户id
    private static final String USER_COLLECT_VIDEO_ID="user_collect_video_id_";
    //用户是否收藏视频 key是用户id
    private static final String USER_IS_COLLECT_VIDEO_ID="user_is_collect_video_id_";
    //是否有菜谱
    private static final String VIDEO_IS_COOKBOOK="video_is_cookbook_";
    //作者详情key key是作者id
    private static final String AUTHOR_DETAIL_KEY="author_detail_key_";
    /**
     * type list
     * 批量导入
     * 所有用户喜爱的id作为分页查询
     */
    @Test
    public void testUSerLikeVideo(){
        List<DataCount> userLikeVideoList = dataCountDao.getUserLikeVideoList();
        /*DataCount dc = userLikeVideoList.get(12);
        String key=USER_LIKE_VIDEO_ID+dc.getUserId();
        List<Long> likeVideoId = dc.getLikeVideoId();
        redisUtilCustom.rightSetAllTypeLongList(key,likeVideoId);*/
        if(!CollectionUtils.isEmpty(userLikeVideoList)){
            for(DataCount dc:userLikeVideoList){
                String key=USER_LIKE_VIDEO_ID+dc.getUserId();
                List<Long> likeVideoId = dc.getLikeVideoIds();
                if(!CollectionUtils.isEmpty(likeVideoId)){
                    List<String> videoIds=new ArrayList<>();
                    for(Long id:likeVideoId){
                        videoIds.add(id.toString());
                    }
                    //rightPush先进先出
                    redisUtilCustom.rightSetAllTypeLongList(key,videoIds);
                }
            }
        }

        /*if(!CollectionUtils.isEmpty(userLikeVideoList)){
            for(DataCount dc:userLikeVideoList){
                System.out.println("用户id:"+dc.getUserId()+";用户收藏视频数:"+dc.getLikeVideoId().size());
            }
        }*/
    }

    /**
     * type list
     * 获取list集合中分页数据
     */
    @Test
    public void getRangeTypeList(){
        String key=USER_LIKE_VIDEO_ID+20;
        List<String> typeList =redisUtilCustom.getTypeList(key, 0, 10);
        System.out.println(JSON.toJSONString(typeList));

    }

    /**
     * type list
     *
     * 向左压入一个数据排在対首
     */
    @Test
    public void testLeftPushTypeList(){
        String key =USER_LIKE_VIDEO_ID+20;
        String value="30";
        redisUtilCustom.leftSetTypeLongList(key,value);
    }

    /**
     * type list
     * 删除队列中的value
     */
    @Test
    public void deleteValueTypeList(){
        String key=USER_LIKE_VIDEO_ID+20;
        String value="30";
        redisUtilCustom.deleteValueTypeList(key,value);
    }

    /**
     * type hash
     * 批量导入
     * 所有用户喜爱的id，用hash表作为是否喜爱
     */
    @Test
    public void testHashSetTypeHash(){
        List<DataCount> userLikeVideoList = dataCountDao.getUserLikeVideoList();
        if(!CollectionUtils.isEmpty(userLikeVideoList)){
            for(DataCount dc:userLikeVideoList){
                List<Long> likeVideoId = dc.getLikeVideoIds();
                if(!CollectionUtils.isEmpty(likeVideoId)){
                    String key=USER_IS_LIKE_VIDEO_ID+dc.getUserId();
                    Map<String,String> map=new HashMap<>();
                    for(Long videoId:likeVideoId){
                        String id = videoId.toString();
                        //批量导入map
                        map.put(id,id);
                    }
                    redisUtilCustom.hashSetMapTypeHash(key,map);
                }

            }
        }
    }

    /**
     * type hash
     * 根据key和valueKey查询valueKey的值
     */
    @Test
    public void getHashMapTypeHash(){
        String key=USER_IS_LIKE_VIDEO_ID+20;
        String valueKey="3935";
        Object hashMapTypeHash = redisUtilCustom.getHashMapTypeHash(key, valueKey);
        if(hashMapTypeHash!=null){
            System.out.println(JSON.toJSONString(hashMapTypeHash));
        }
    }

    /**
     * type hash
     * key查询多个keyValue的值
     * @return
     */
    @Test
    public void mGetHashMapListTypeHash(){
        String key=USER_IS_LIKE_VIDEO_ID+20;
        String valueKey="3935";
        String valueKey2="4004";
        List list = new ArrayList<>();
        list.add(valueKey);
        list.add(valueKey2);
        List<Object> list1 = redisUtilCustom.mGetHashMapListTypeHash(key, list);
        if(!CollectionUtils.isEmpty(list1)){
            System.out.println(JSON.toJSONString(list1));
        }
    }

    /**
     * type hash
     * 删除key下的对应value key的值
     * @return
     */
    @Test
    public void deleteValueTypeHash(){
            String key=USER_IS_LIKE_VIDEO_ID+20;
            String valueKey="3935";
            redisUtilCustom.deleteValueTypeHash(key,valueKey);
    }


    /**
     * type hash
     * 批量导入视频喜爱、分享、评论数
     * 所有用户喜爱的id，用hash表作为是否喜爱
     */
    @Test
    public void setLikeShareCommentNumTypeHash(){
        //查询视频喜爱数
        List<DataCount> videoLikeNums = dataCountDao.getVideoLikeNum();
        //查询视频分享数
        List<DataCount> videoShareNums = dataCountDao.getVideoShareNum();
        //查询视频评论数
        List<DataCount> videoCommentNums = dataCountDao.getVideoCommentNum();
        //导入视频喜爱数
        if(!CollectionUtils.isEmpty(videoLikeNums)){
            //喜爱数的key
            Map<String,String> likeMap=new HashMap<>();
            for(DataCount dc:videoLikeNums){
                String videoId = dc.getVideoId().toString();
                String videoLikeNum = dc.getVideoLikeNum().toString();
                likeMap.put(videoId,videoLikeNum);
            }
            redisUtilCustom.hashSetMapTypeHash(VIDEO_LIKE_KEY,likeMap);
        }
        //导入视频分享数
        if(!CollectionUtils.isEmpty(videoShareNums)){
            //视频分享数
            Map<String,String> shareMap=new HashMap<>();
            for(DataCount dc:videoShareNums){
                String videoId = dc.getVideoId().toString();
                String videoShareNum = dc.getVideoShareNum().toString();
                shareMap.put(videoId,videoShareNum);
            }
            redisUtilCustom.hashSetMapTypeHash(VIDEO_SHARE_KEY,shareMap);
        }
        //导入视频评论数
        if(!CollectionUtils.isEmpty(videoCommentNums)){
            //视频评论数
            Map<String,String> commentMap=new HashMap<>();
            for(DataCount dc:videoCommentNums){
                String videoId = dc.getVideoId().toString();
                String videoCommentNum = dc.getVideoCommentNum().toString();
                commentMap.put(videoId,videoCommentNum);
            }
            redisUtilCustom.hashSetMapTypeHash(VIDEO_COMMENT_KEY,commentMap);
        }
    }


    /**
     * type hash
     * 批量导入
     *是否关注作者
     */
    @Test
    public void setAttentionIsAuthorAllTypeHash(){
        List<DataCount> authorIdList = dataCountDao.getAttentionAuthorIdList();
        if(!CollectionUtils.isEmpty(authorIdList)){
            for(DataCount dc:authorIdList){
                //System.out.println("userId:"+dc.getUserId()+",集合："+JSON.toJSONString(dc.getAttentionAuthorId()));
                Long userId = dc.getUserId();
                List<Long> attentionAuthorIds = dc.getAttentionAuthorIds();
                String userKey=ATTENTION_IS_AUTHOR_USER_ID+userId;
                if(!CollectionUtils.isEmpty(attentionAuthorIds)){
                    Map<String,String> attentionMap=new HashMap<>();
                    for(Long id:attentionAuthorIds){
                        String authorId=id.toString();
                        attentionMap.put(authorId,authorId);
                    }
                    redisUtilCustom.hashSetMapTypeHash(userKey,attentionMap);
                }
            }
        }
    }

    /**
     * type list
     * 批量导入
     *关注作者列表
     */
    @Test
    public void setAttentionAuthorAllTypeList(){
        List<DataCount> authorIdList = dataCountDao.getAttentionAuthorIdList();
        if(!CollectionUtils.isEmpty(authorIdList)){
            for(DataCount dc:authorIdList){
                Long userId = dc.getUserId();
                List<Long> attentionAuthorIds = dc.getAttentionAuthorIds();
                String userKey=ATTENTION_AUTHOR_USER_ID+userId;
                if(!CollectionUtils.isEmpty(attentionAuthorIds)){
                    List<String> ids=new ArrayList<>();
                    for(Long id:attentionAuthorIds){
                        ids.add(id.toString());
                    }
                    redisUtilCustom.rightSetAllTypeLongList(userKey,ids);
                }
            }
        }
    }

    /**
     * type list
     * 批量导入
     *用户收藏视频的id集合
     */
    @Test
    public void setCollectVideoIdAllTypeList(){
        List<DataCount> authorIdList = dataCountDao.getCollectVideoList();
        if(!CollectionUtils.isEmpty(authorIdList)){
            for(DataCount dc:authorIdList){
                Long userId = dc.getUserId();
                List<Long> collectVideoIds = dc.getCollectVideoIds();
                String userKey=USER_COLLECT_VIDEO_ID+userId;
                if(!CollectionUtils.isEmpty(collectVideoIds)){
                    List<String> ids=new ArrayList<>();
                    for(Long id:collectVideoIds){
                        ids.add(id.toString());
                    }
                    redisUtilCustom.rightSetAllTypeLongList(userKey,ids);
                }
            }
        }
    }

    /**
     * type hash
     * 批量导入
     *是否关注作者
     */
    @Test
    public void setCollectIsVideoAllTypeHash(){
        List<DataCount> collectVideoList = dataCountDao.getCollectVideoList();
        if(!CollectionUtils.isEmpty(collectVideoList)){
            for(DataCount dc:collectVideoList){
                Long userId = dc.getUserId();
                List<Long> collectVideoIds = dc.getCollectVideoIds();
                String userKey=USER_IS_COLLECT_VIDEO_ID+userId;
                if(!CollectionUtils.isEmpty(collectVideoIds)){
                    Map<String,String> collection=new HashMap<>();
                    for(Long id:collectVideoIds){
                        String videoId=id.toString();
                        collection.put(videoId,videoId);
                    }
                    redisUtilCustom.hashSetMapTypeHash(userKey,collection);
                }
            }
        }
    }

    /**
     * type String
     * 批量插入食谱
     */
    @Test
    public void setCookbook(){
        List<Long> cookbookVideoList = dataCountDao.getCookbookVideoList();
        if(!CollectionUtils.isEmpty(cookbookVideoList)){
            Map<String,String> cookMap=new HashMap<>();
            for(Long id:cookbookVideoList){
                String videoId = id.toString();
                String key=VIDEO_IS_COOKBOOK+videoId;
                cookMap.put(key,videoId);
            }
            redisUtilCustom.msetTypeString(cookMap);
        }
    }

    /**
     * type string
     * 设置作者详情
     *
     */
    @Test
    public void setDetail(){
        List<Author> authorList = authorDao.getAuthorList();
        if(!CollectionUtils.isEmpty(authorList)){
            Map<String,String> authorMap=new HashMap<>();
            for(Author author:authorList){
                String authorkey=AUTHOR_DETAIL_KEY+author.getId();
                Object o = JSON.toJSON(author);

                String s = JSON.toJSONString(author);
                authorMap.put(authorkey,s);
            }
            redisUtilCustom.msetTypeString(authorMap);
        }
    }

    @Test
    public void getAuthorDetail(){
        List<String> authorList=new ArrayList<>();
        String authorId1=AUTHOR_DETAIL_KEY+1;
        String authorId2=AUTHOR_DETAIL_KEY+6;
        authorList.add(authorId1);
        authorList.add(authorId2);
        List<String> authors = redisUtilCustom.mgetTypeString(authorList);
        String s1 = authors.toString();
        List<Author> authors1 = JSONArray.parseArray(s1, Author.class);
        System.out.println("author1:--"+JSON.toJSON(authors1));
        if(!CollectionUtils.isEmpty(authors)){
            /*String s = JSON.toJSONString(authors);
            System.out.println(s);
            List<Author> authors1 = JSON.parseArray(s, Author.class);
            System.out.println(JSON.toJSONString(authors1));*/
            //JSONObject.parseArray(authors,authors);
            for(String s:authors){
                Author author = JSON.parseObject(s, Author.class);
                System.out.println(JSON.toJSONString(author));
            }
        }
    }




}
