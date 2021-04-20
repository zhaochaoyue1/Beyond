import requests

url = "http://www.baidu.com"
response = requests.get(url)
response.encoding = "utf-8"
print("\nr的类型" + str(type(response)))
print("\n状态码是:" + str(response.status_code))
print("\n头部信息:" + str(response.headers))
print("\n响应内容:")
print(response.text)

# 保存文件
##打开一个文件，w是文件不存在则新建一个文件，这里不用wb是因为不用保存成二进制
file = open("/Users/coohua/Downloads/python/baidu.html", "w", encoding="utf")
file.write(response.text)
file.close()
