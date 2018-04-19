#!/bin/bash
fromFile="/mnt/files/tomcat4Server/webapps/server"

if [ -d $formFile ]; then
	echo "copying start"
	cp -rf $fromFile /mnt/files/files4Copy
	echo "copying end"
fi

