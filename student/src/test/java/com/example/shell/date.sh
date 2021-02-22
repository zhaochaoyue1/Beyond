#!/bin/bash
user_input=$1
# shellcheck disable=SC2070
if [ -n "$1" ] &&  [ -n "$2" ];
then
   user_input="$1 $2"
fi
if [ -z $1 ];
then
    echo "now:"
    date "+%Y-%m-%d %H:%M:%S"
    date +%s
    exit
fi
#时间戳是10位，但是shell取字符串长度时会多一位
if [ "${#user_input}" -le 11 ];
then
    date -j -f "%s" "${user_input}" "+%Y-%m-%d %H:%M:%S"
#时期类型转时间戳
elif [ "${#user_input}" -gt 15 ];
then
    date -j -f "%Y-%m-%d %H:%M:%S" "${user_input}" "+%s"
else
    #毫秒时间戳
    # shellcheck disable=SC2006
    # shellcheck disable=SC2003
    num=`expr "${user_input}" / 1000`
    date -j -f "%s" "$num" "+%Y-%m-%d %H:%M:%S"
fi
exit