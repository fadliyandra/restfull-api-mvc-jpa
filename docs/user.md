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

Endpoint : get/api/users/cuurent

Request Header :

- X-API-TOKEN : Token (Mandatory)


Response Body (Success) :

'''
json
{
"data" : {
"username" "fadli"
"name" : "Eko Kurniawan Khannedy"

    }
}

'''

Response Body (Failed, 401) :

'''
{
"errors" : "Unathorize"
}
'''


## Update User

Request Header :

- X-API-TOKEN : Token (Mandatory)

Endpoint : patch/api/users/cuurent

Request Body :
'''
{
"name" : "Fadli Yandra" // put if only want to update name
"password" : "new password" //put if only want to update password
}

'''

Response Body (Success) :

'''
json
{
"data" : {
"username" "fadli"
"name" : "Eko Kurniawan Khannedy"

    }
}

'''

Response Body (Failed, 401) :

'''
{
"errors" : "Unathorize"
}
'''


## LogOut User

Endpoint : DELETE /api/auth/logout

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

'''
json
{
"data" : "OK"
}
'''