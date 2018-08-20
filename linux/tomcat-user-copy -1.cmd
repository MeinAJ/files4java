#!/bin/bash
#先获取备份文件下的文件名


#复制user服务到备份文件中
dirName=user
dirDate=date +'%Y%m%d'
dirVersion=1;
dirFullNameArr=(find /mnt/java/tomcat/apache-tomcat-7.0.79-shj-service-user -name 'user*V*' -exec basename {} \; | grep '${dirName}${dirDate}V?*' | awk '{print}')
dirFullNameCopy=${dirName}${dirDate}


#循环获取到今日最终版本

if [[ dirFullNameArr ]];then
    #不为空,今天有备份了,获取到最大的版本号
    	verArr=()
		n=0
		for j in ${dirFullNameArr[@]}
		    do
			    OLD_IFS="$IFS" 
				IFS="V" 
				arr=($j) 
				IFS="$OLD_IFS" 
				length=${#arr[@]}
				if [[ length eq 2 ]];then
					verArr[$n]=${arr[0]}
					let n+=1
				fi
		done

		#获取到最大的版本号
		max=${verArr[0]}
		for m in ${verArr[@]}
			do
				if [[ max le ${m} ]];then
					max=${m}
				fi
		done

		#最大的版本号+1
		echo ${max}
    else
    #数组为空,今天还没有备份,dirVersion就为1
    dirFullNameCopy=${dirFullNameCopy}'V1'

fi

user-service-source=/mnt/java/tomcat/apache-tomcat-7.0.79-shj-service-user/webapps/user

user-service-destination=/mnt/java/tomcat/apache-tomcat-7.0.79-shj-service-user/
