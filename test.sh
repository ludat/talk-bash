#!/bin/bash

set -euo pipefail

CARPETA_DE_TEST=./example_mavenizado
rm -rf "$CARPETA_DE_TEST"
mkdir "$CARPETA_DE_TEST"
./mavenizar.sh ./example "$CARPETA_DE_TEST"
tree -a "$CARPETA_DE_TEST"
