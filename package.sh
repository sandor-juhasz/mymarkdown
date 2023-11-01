#!/bin/bash -e
#
# Packages the MyMarkdown application into a distributable zip
#

echo "Packaging MyMarkdown..."
cp target/MyMarkdown-1.0-SNAPSHOT-jar-with-dependencies.jar dist/mymarkdown.jar
cd dist
zip mymarkdown.zip *
rm mymarkdown.jar
mv mymarkdown.zip ..
cd ..
echo Done
