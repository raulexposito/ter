#!/bin/bash

# https://github.com/mattgreen/watchexec

# Ejecutar con:
# watchexec ./script.sh

mvn test
if [[ "$?" -ne 0 ]] ; then
  notify-send "revisa la traza"
fi
echo "Última ejecución: `date`"
