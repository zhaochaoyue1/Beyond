#绕过反爬机制，以知乎为例
import requests
http = "http://www.zhihu.com";
response = requests.get(http)
print("第一次，不设置请求头，状态码:"+str(response.status_code))
print("第一次，不设置请求头，状态码:"+response.text)
#设置头部信息，伪装浏览器
headers = {
    "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36"
}
headGet = requests.get(http, headers=headers)
print(headGet.status_code)
print(headGet.text)
