#!/usr/local/bin/expect -f
# https://www.cnblogs.com/t-gonna/p/11547289.html
set redis [lindex $argv 0]
set timeout 30
spawn ssh zhaochaoyue@123.56.23.232 -p 39986
expect {
	"*password:" {send "84ur3weo#xf\r"}
}
expect {
	"*zhaochaoyue@beijin-vpc-control001*:" {send "redis-cli  -h ${redis}-redis001.coohua-inc.com  -c -p  9720\r"}
}
interact