FROM amazoncorretto:20
COPY target/MyMarkdown-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/local/share/mymarkdown/mymarkdown.jar
COPY mymarkdown /usr/local/bin/mymarkdown
COPY process-notes-dir /usr/local/bin/process-notes-dir
CMD process-notes-dir /mnt
