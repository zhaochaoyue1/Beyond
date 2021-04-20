#!/usr/local/bin/python3
#导入爬虫库，不然调用不了爬虫的函数
import requests
#生成一个response
response = requests.get("http://www.baidu.com")
#设置编码格式
response.encoding = response.apparent_encoding
#打印状态码
print("状态码:"+str(response.status_code))
#输出爬取的信息
print(response.text)