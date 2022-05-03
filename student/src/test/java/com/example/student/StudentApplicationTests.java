package com.example.student;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.student.project.dao.AdBoundUserDao;
import com.example.student.project.dao.CaladerDao;
import com.example.student.project.dao.PeopleDao;
import com.example.student.project.domain.People;
import com.example.student.project.dao.PeopleDao;
import com.example.student.project.service.CalenderService;
import com.example.student.solr.ShortVedio;
import com.example.student.util.DateTimeUtils;
import com.example.student.util.RandomUtil;
import lombok.extern.log4j.Log4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class StudentApplicationTests {
    /*@Value("${spring.datasource.url}")
    private String url;*/
    @Resource
    private PeopleDao peopleDao;
    @Resource
    private SolrTemplate solrTemplate;
    @Resource
    private CaladerDao calenderService;
    @Resource
    private AdBoundUserDao adBoundUserDao;

    @Test
    public void testDuplicate() {
        Boolean userIsExist = adBoundUserDao.getUserIsExist(1L);
        System.out.println(userIsExist);
    }


    @Test
    public void testAdBoundUser() {
        for (int i = 1; i <= 996; i++) {
            int h = RandomUtil.random(2, 22);
            int m = RandomUtil.random(0, 60);
            String s = "00";
            StringBuilder sb = new StringBuilder(" ");
            if (h >= 10) {
                sb.append(h);
            } else {
                sb.append(0).append(h);
            }
            sb.append(":");
            if (m >= 10) {
                sb.append(m);
            } else {
                sb.append(0).append(m);
            }
            sb.append(":");
            String s1 = sb.append(s).toString();
            adBoundUserDao.update(i, s1);
        }
    }


    @Test
    public void TestSolrLenove() {
        Query query = new SimpleQuery("*:*");
        //ScoredPage<ShortVedio> shortVedios = solrTemplate.queryForPage(query, ShortVedio.class);
        //System.out.println(JSON.toJSON(shortVedios));
    }

    private static Logger log = LoggerFactory.getLogger(StudentApplicationTests.class);
    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    @Test
    public void contextLoads() {
        List<People> peopleList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            People people = new People();
            people.setId(i + 1);
            people.setCount(i);
            peopleList.add(people);
        }
        //peopleDao.batchUpdat(peopleList);
    }

    @Test
    public void testConcurrenry() {
//        RunableTest runableTest1 = new RunableTest(peopleDao);
//        RunableTest runableTest2= new RunableTest(peopleDao);
//        runableTest1.run();
//        runableTest2.run();

    }

    @Test
    public void TestSkipList() {
        ConcurrentSkipListMap<Integer, Object> skipListMap = new ConcurrentSkipListMap<>();
        //ConcurrentHashMap<Integer, Object> hashMap = new ConcurrentHashMap<>();
        long l = System.currentTimeMillis();
        for (int i = 1; i <= 16000; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("赵超越" + i);
            student.setAge(i);
            skipListMap.put(i, student);
        }

        long l1 = System.currentTimeMillis();
        System.out.println("---------------------------------" + (l1 - l));
        long l2 = System.nanoTime();
        Object o = skipListMap.get(13568);
        long l3 = System.nanoTime();
        System.out.println("-----------------------------------" + (l3 - l2));
    }

    @Test
    public void testYUSEFU() {
        //先给这41个人按顺序排列，初始数值是key值；
        //Map<Integer,Integer> map=new HashMap<>();
        List list = new LinkedList();
        for (int i = 1; i < 42; i++) {
            //map.put(i,i);
            list.add(i);
        }

        for (list.size(); list.size() > 2; ) {
            int i1 = list.size() / 3;
            for (int i = 0; i < i1; i++) {

            }

        }
    }

    @Test
    public void testString() {
        String name = "小明";
        name = stringToSwap(name);
        System.out.println(name);
    }

    private String stringToSwap(String name) {
        if (name.equals("小明")) {
            name = "小红";
        }
        return name;
    }

    @Test
    public void solrTest() throws IOException, SolrServerException {
        SolrQuery sq = new SolrQuery();
        //sq.setParam("name","肉");
        sq.set("q", "name:肉");
        //sq.setParam("indent",true);
        //sq.setParam("wt","json");
        sq.set("indent", "true");
        sq.set("wt", "json");
        sq.set("start", 0);
        sq.set("rows", 10);
        //sq.set("fl","name,updateTime,title,lable");
        sq.set("fl", "name");
        sq.set("qf", "name^10");
        //sq.setStart(0);
        //sq.setRows(10);
        sq.addSort("updateTime", SolrQuery.ORDER.desc);
        sq.addSort("onlieTime", SolrQuery.ORDER.desc);
        //sq.setRequestHandler("/browse");
        SolrClient solrClient = new HttpSolrClient("http://47.105.200.200:8080/solr/mysolr");

        QueryResponse query = solrClient.query(sq);
        SolrDocumentList results = query.getResults();
        for (SolrDocument solr : results) {
            //String name = (String )solr.get("name");
            System.out.println(JSON.toJSONString(solr));
            //System.out.println(name);
        }
    }

    @Test
    public void testSort() {
        long l = System.nanoTime();
        Set<Long> longs = new HashSet<>();
        longs.add(1L);
        longs.add(6L);
        longs.add(5L);
        longs.add(0L);
        Object[] objects = longs.toArray();
        Arrays.sort(objects);
        long l1 = System.nanoTime();
        System.out.println(l1 - l);
        System.out.println(JSON.toJSONString(longs));
    }

    @Test
    public void executors() {
        long l = System.currentTimeMillis();
        long l1;
        boolean bn = false;
        try {

            for (int i = 0; i < 20; i++) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        /*Logger.logMsg(1,Thread.currentThread().getName());*/
                        log.info(Thread.currentThread().getName());
                    }
                };
                executorService.submit(runnable);
            }
            try {
                executorService.shutdown();
                bn = executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } finally {
            if (bn) {
                l1 = System.currentTimeMillis();
                log.info("---------------------------------------------------------------------------------");
                log.info((l1 - l) + "");
            }
        }

    }

    @Test
    public void testCallables() {
        long l = System.currentTimeMillis();
        List<Future<TestCallable>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TestCallable testCallable = new TestCallable();
            futures.add(executorService.submit(testCallable));
        }
        for (int i = 0; i < 20; i++) {
            try {
                futures.get(i).get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        long l1 = System.currentTimeMillis();
        log.info((l1 - l) + "ms");
    }

    @Test
    public void testTimeStamp() {
        Lock lock = new ReentrantLock();
        try {
            if (lock.tryLock(4, TimeUnit.SECONDS)) {
                long l = System.nanoTime();
                long l1 = System.currentTimeMillis();
                System.out.println(l);
                System.out.println(l1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void testList() throws Exception {
        String s = "{\"member\":{\"balance\":0.00,\"balancePwd\":\"\",\"canReceiveEmail\":1,\"canReceiveSms\":1,\"customerToken\":\"q6TVP2dWBNe2ABXH7TWTKPQK4OsRpGlMyZ8tTgcilJ8d3kagqluG5muBk8m58TAnbiSDd4U9WpYgCnEewuqa1w==\",\"email\":\"\",\"emailVerifyCode\":\"\",\"grade\":1,\"gradeValue\":0,\"id\":18559,\"integral\":0,\"isEmailVerify\":0,\"isSmsVerify\":1,\"lastLoginIp\":\"114.254.143.198\",\"lastLoginTime\":1546945660000,\"loginNumber\":0,\"mobile\":\"18515430634\",\"name\":\"小碗ibbe\",\"password\":\"e10adc3949ba59abbe56e057f20f883e\",\"phone\":\"18515430634\",\"phoneType\":\"HUAWEI\",\"pic\":\"https://xiaowan-image.oss-cn-beijing.aliyuncs.com/user_info.jpg\",\"pwdErrCount\":0,\"registerTime\":1546945660000,\"registrationId\":\"\",\"smsVerifyCode\":\"\",\"source\":2,\"status\":1,\"updateTime\":1563522148000},\"token\":\"memberSession_c5e244b8b3964f7eb1b3fbddc207719f\"}";
        Object s1 = JSON.parse(s);
        Field member2 = s1.getClass().getDeclaredField("member");

        //Object member = parse.get("member");
        //Member member1 = JSON.parseObject(member.toString(), Member.class);
        //System.out.println(member1);
    }


    @Test
    public void testFile() {
        String lu = "/Users/coohua/Downloads/hlall";
        getAllFileName(lu);
    }

    @Test
    public void testFile2() {
        //String calendar = calenderService.getCalendar("2020-11-18");
        //JSONObject parse = JSONObject.parseObject(calendar);
        //System.out.println(parse);
        Date date = DateTimeUtils.parseYYYYMMDD("2020-2-5");
        System.out.println(date);
    }


    public void getAllFileName(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        String[] names = file.list();
        if (names != null) {
            for (int i = 0; i < names.length; i++) {
                String name = names[i];
                String[] split = name.split("\\.");
                String fileName = path + "/" + name;
                getFile(split[0], fileName);
            }
        }

        //查询子文件夹
        /*for(File com.example.spi.SpiInterface:files){
            if(com.example.spi.SpiInterface.isDirectory()){//如果文件夹下有子文件夹，获取子文件夹下的所有文件全路径。
                getAllFileName(com.example.spi.SpiInterface.getAbsolutePath()+"\\");
            }
        }*/
    }

    public void getFile(String id, String fileName) {
        if (StringUtils.isEmpty(id)) {
            return;
        }
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            String text = sbf.toString();
            if (StringUtils.isEmpty(id)) {
                return;
            }
            Date date = DateTimeUtils.parseYYYYMMDD(id);
            String dailyVersion = DateTimeUtils.getDailyVersion(date);
            long time = date.getTime();
            calenderService.saveCalender(dailyVersion, text, time);
            /*String calendar = calenderService.getCalendar(dailyVersion);
            if (StringUtils.isEmpty(calendar)) {

            }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}

class TestCallable implements Callable {
    private static Logger log = LoggerFactory.getLogger(TestCallable.class);

    @Override
    public Object call() throws Exception {
        log.info(Thread.currentThread().getName());
        return null;
    }
}
