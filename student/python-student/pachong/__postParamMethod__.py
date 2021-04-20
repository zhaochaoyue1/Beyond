import requests
data = {"name":"hezhi","age":20}
post = requests.post("http://httpbin.org/post", params=data)
print(post.status_code)
print(post.text)