import requests

response = requests.get("http://httpbin.org/get?/name=hezhi&age=20")
print(response.status_code)
print(response.text)

data = {"name":"hezhi","age":20}
requests_param = requests.get("http://httpbin.org/get", params=data)
print(requests_param.status_code)
print(requests_param.text)
