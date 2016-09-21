# Simple concourse pipeline running of mvn

### To push to pcf dev
```bash
fly -t lite trigger-job --job reaction/deploy-local
```

### Following handy commands used during the development
```bash
fly -t lite destroy-pipeline -p reaction
fly -t lite set-pipeline -p reaction -c ci/pipeline.yml -l ci/credentials-local.yml
fly -t lite unpause-pipeline --pipeline reaction
```

### Execute task locally
```bash
fly -t lite execute -c ci/tasks/unit.yml --input resource-app-repo=.
```

#### Based on the [sample pipeline](https://github.com/rjain-pivotal/PCF-demo/blob/master/ci/pipeline.yml)



