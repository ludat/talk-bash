#!/usr/bin/env bash

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

main() {
    carpeta_original=$(realpath "$1")
    carpeta_nueva=$(realpath "$2")

    carpeta_tests_maven="${carpeta_nueva}/src/test/java"
    carpeta_produ_maven="${carpeta_nueva}/src/main/java"

    # Crear carpetas con estructura de proyecto Maven
    mkdir -p "$carpeta_tests_maven" "$carpeta_produ_maven"

    # Copiar los archivos del proyecto a la carpeta mavenizada
    cd $carpeta_original

    for archivo_test in $(find src -type f -name "*Test.java")
    do
        path_relativo=$(echo $archivo_test | sed 's/^src\///')
        safe_cp "$archivo_test" "$carpeta_tests_maven/$path_relativo"
    done

    for archivo_produccion in $(find src -type f ! -name "*Test.java")
    do
        path_relativo=$(echo $archivo_produccion | sed 's/^src\///')
        safe_cp "$archivo_produccion" "$carpeta_produ_maven/$path_relativo"
    done

    # Generar el POM
    nombre_proyecto=$(nombre_proyecto_eclipse)
    artifact_id=$(echo "${nombre_proyecto}" | tokenizar)

    cat "$SCRIPT_DIR/pom_template.xml" |
        sed "s/__ARTIFACT_ID__/$artifact_id/" |
        sed "s/__PROJECT_NAME__/$nombre_proyecto/" > "$carpeta_nueva/pom.xml"

    # ===========
    # For testing
    # ===========
    # when-changed script.sh "clear && ./script.sh C1-Idiom-Exercise/JavaProjects/C1-Idiom-Exercise/ \"\$(mktemp -d)\""
    #
    # tree $carpeta_nueva
    # rm -rf "$carpeta_nueva"
}

safe_cp() {
    origen=$1
    destino=$2

    # Create folders when necessary
    mkdir -p "$(dirname "$destino")"

    cp "$origen" "$destino"
}

nombre_proyecto_eclipse() {
    sed -n 's:.*<name>\(.*\)</name>.*:\1:p' .project | head -n 1
}

tokenizar() {
    sed 's/ \+/-/g' | # Reemplazar espacios por -
    tr '[:upper:]' '[:lower:]' | # Pasar a minuscula
    sed "s/[^a-z0-9\-]//g" # Eliminar caracteres no alfanumericos (ni -)
}

main "$@"
