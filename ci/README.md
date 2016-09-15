fly -t lite set-pipeline -p reaction -c pipeline.yml -l credentials-local.yml
fly -t lite trigger-job --job reaction/deploy-local
fly -t lite destroy-pipeline -p reaction
fly -t lite destroy-pipeline -p dojo-pipeline
fly -t lite destroy-pipeline -p spring-music-pipeline
fly -t lite destroy-pipeline -p spring-music
fly -t lite destroy-pipeline -p hello-world