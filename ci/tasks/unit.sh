#!/bin/sh

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

cd $inputDir

mkdir email-out

./mvnw clean test --log-file email-out/log.out

output_body_file=email-out/$output_body_file
output_subject_file=email-out/$output_subject_file

echo -e "Email from unit test on $(date)" > $output_subject_file
echo -e "Some text to add to mail body" > $output_body_file