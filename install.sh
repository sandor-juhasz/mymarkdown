#!/bin/bash -e

TEMP_DIR=/tmp/mymarkdown

echo "Creating temporary directory $TEMP_DIR"
mkdir -p "${TEMP_DIR}"
pushd "${TEMP_DIR}"

echo "Downloading MyMarkdown..."
curl -fsSL https://github.com/sandor-juhasz/mymarkdown/releases/download/v1.0/mymarkdown.zip -o mymarkdown.zip

echo "Unpacking..."
unzip mymarkdown.zip

./install

echo "Cleanup..."
popd
rm -r "${TEMP_DIR}"

echo "Done"