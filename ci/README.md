fly -t lite set-pipeline -p reaction -c ci/pipeline.yml -l ci/credentials-local.yml
fly -t lite unpause-pipeline --pipeline reaction
fly -t lite trigger-job --job reaction/deploy-local
fly -t lite destroy-pipeline -p reaction
fly -t lite destroy-pipeline -p dojo-pipeline
fly -t lite destroy-pipeline -p spring-music-pipeline
fly -t lite destroy-pipeline -p spring-music
fly -t lite destroy-pipeline -p hello-world

https://github.com/rjain-pivotal/PCF-demo/blob/master/ci/pipeline.yml
