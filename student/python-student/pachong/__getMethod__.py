#!/usr/local/bin/python3
# 第二个get方法实例
import requests #先导入爬虫的库，不然调用不了爬虫的函数
response = requests.get("http://httpbin.org/get") #get方法
print( response.status_code ) #状态码
print( response.text )