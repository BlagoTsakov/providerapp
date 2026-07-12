# providerapp

EDS Provider app

curl -d @requests\create-asset.json -H "Content-Type: application/json" http://localhost:8080/management/v3/assets
curl -d @requests\create-policy.json -H "Content-Type: application/json" http://localhost:8080/management/v3/policydefinitions
curl -d @requests\create-contract-definition.json -H "Content-Type: application/json" http://localhost:8080/management/v3/contractdefinitions