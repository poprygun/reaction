#!/bin/sh
set -exu

inputDir=

while [ $# -gt 0 ]; do
  case $1 in
    -i | --input-dir )
      inputDir=$2
      shift
      ;;
    * )
      echo "Unrecognized option: $1" 1>&2
      exit 1
      ;;
  esac
  shift
done

error_and_exit() {
  echo $1 >&2
  exit 1
}

if [ ! -d "$inputDir" ]; then
  error_and_exit "missing input directory: $inputDir"
fi

echo "Unit test build result $(date)" > email-out/$output_subject_file

cd $inputDir

./mvnw clean test --log-file ../email-out/$output_body_file
