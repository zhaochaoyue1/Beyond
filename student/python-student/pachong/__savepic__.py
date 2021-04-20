import requests

get = requests.get("https://www.baidu.com/img/baidu_jgylogo3.gif")
file = open("/Users/coohua/Downloads/python/baidu_logo.gif","wb")
file.write(get.content)
file.close()
