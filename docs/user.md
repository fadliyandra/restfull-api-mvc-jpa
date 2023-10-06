#User API Spec

## Register User

Endpoint : POST /api/user

Request Body :

'''
    json
{
    "username" : "fadli",
    "pasword" : "rahsia",
    "name"     : "Fsdli Yandra"
}
'''

Response Body (Success) : 

'''
    json
{
"data" : "OK"

}
'''

Response Body (Failed) :
'''
{

    "errors" : "Username must no blank"
}
'''


## Login User

Endpoint : POST /api/auth/login

Request Body :

'''
json
{
"username" : "fadli",
"pasword"  : "rahsia"

}
'''

Response Body (Success) :

'''
json
{
"data" : {
    "token" : "TOKEN",
    "expiredAt" : 2342342423423 //millisecond

}

}
'''

Response Body (Failed, 401) :

'''
{
"errors" : "Username or password wrong"
}
'''


## Get User


## Update User



## LogOut User
