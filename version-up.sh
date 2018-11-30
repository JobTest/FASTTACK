#!/bin/bash

#
# version-up.sh <TO>
#
# ./version-up.sh 1.1.649-SNAPSHOT
#

version_file="version.txt"

RELEASE_VER_FROM=$(cat "$version_file")
RELEASE_VER_TO=$1
POM_FILE='pom.xml'


COUNTER=0

shopt -s globstar

for pom_file in **/$POM_FILE
do
    if [ -f "$pom_file" ];
    then
        COUNTER=$((COUNTER+1))
        echo "$COUNTER. $pom_file"
        pom_file_tmp=$pom_file".tmp"

        #
        # Up Version profile
        #
        sed '/<project / {
            :start
            N
            /<\/project>$/!b start
            /<groupId>com.cts.fasttack/ {
                s/\(<version>\)'"$RELEASE_VER_FROM"'\(<\/version>\)/\1'"$RELEASE_VER_TO"'\2/
            }
        }' $pom_file > $pom_file_tmp

        cp $pom_file_tmp $pom_file
        echo $RELEASE_VER_TO > $version_file
        rm $pom_file_tmp
    fi
done
