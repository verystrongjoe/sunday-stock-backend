== Authorization Code

http://localhost:8013/oauth/authorize?response_type=code&client_id=client&client_secret=secret&scope=read

curl localhost:8013/oauth/token -u client:secret -d "grant_type=authorization_code&code=gnXM8p"

curl localhost:8013/messages/search/inbox -H "Authorization: Bearer e75aecc2-fb64-4ee0-a037-24daa7f7dae9"

== Implicit

http://localhost:8013/oauth/authorize?response_type=token&client_id=client&client_secret=secret&scope=read

curl localhost:8013/messages/search/inbox -H "Authorization: Bearer db8ac1ac-4189-41ff-9241-f8dfee5644b0"

== Password

curl localhost:8013/oauth/token -d "grant_type=password&username=rob@example.com&password=password&scope=read" -u client:secret

curl localhost:8013/messages/search/inbox -H "Authorization: Bearer cf7b4c2e-339f-442b-884e-8b2c413b8dcc"

curl -v localhost:8013/messages/ -X POST -d '{"summary":"I am","text":"using OAuth", "to" : "http://localhost:8013/users/1", "from":"http://localhost:8013/users/0"}' -H "Content-Type: application/json" -H "Authorization: Bearer db0d7df4-2712-4c7e-a5ab-d5add86427fe"