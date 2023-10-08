# Contact API Spect

##Create Contact

Endpoint : POST/api/contacts

Request Header :

- X-API-TOKEN : Token (Mandatory)


Requst Body :

'''
    json
{
"firstName" : "Fadli",
"lastName" : "Yandra",
"email" : "fadliyandra@ymail.com",
"phone" : "082387123063"

}
'''

Response Body (Succes):

'''
    json
{
"data"{
    "id" : "random-String"
    "firstName" : "Fadli",
    "lastName" : "Yandra",
    "email" : "fadliyandra@ymail.com",
    "phone" : "082387123063"
}
}
'''



Response Body (Failed) :
'''
    json
{
"errors" : "Email format invalid , phone format invalid, ..."
}
'''


## Update Contact

Endpoint : PUT /api/contacts/{idContacts}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Requst Body :

'''
json
{
"firstName" : "Fadli",
"lastName" : "Yandra",
"email" : "fadliyandra@ymail.com",
"phone" : "082387123063"

}
'''


Response Body (Succes):

'''
json
{
"data"{
"id" : "random-String"
"firstName" : "Fadli",
"lastName" : "Yandra",
"email" : "fadliyandra@ymail.com",
"phone" : "082387123063"
}
}
'''


Response Body (Failed) :

'''
json
{
"errors" : "Email format invalid , phone format invalid, ..."
}
'''


## Get Contact
Endpoint : GET /api/contacts/{idContacts}

Request Header :

- X-API-TOKEN : Token (Mandatory)



Response Body (Succes):

'''
json
{
"data"{
"id" : "random-String"
"firstName" : "Fadli",
"lastName" : "Yandra",
"email" : "fadliyandra@ymail.com",
"phone" : "082387123063"
}
}
'''

Response Body (Failed) :

'''
json
{
"errors" : "contact is not found"
}
'''



## Search Contact
Endpoint : GET /api/contacts


Query Params :
-name : String , contact first name or last name, using like query, optional
-phone : String , contact phone, using like query, optional
-email : String , contact email, using like query, optional
-page : Integer , start from 0, default 0
-size : Integer , default 10



Request Header :

- X-API-TOKEN : Token (Mandatory)


Response Body (Succes):

'''json
{
"data" : [
{
"id" : "random-String"
"firstName" : "Fadli",
"lastName" : "Yandra",
"email" : "fadliyandra@ymail.com",
"phone" : "082387123063"

}
],
"paging" : {
"currentPage" : 0,
"totalPage" : 10,
"size" : 10
}

}
'''



Response Body (Failed) :

'''
json
{
"errors" : "anauthorize"
}
'''


## Remove Contact
Endpoint : DELETE /api/contacts/{idContacts}

Request Header :

- X-API-TOKEN : Token (Mandatory)


Response Body (Succes):
'''json
{
"data" : "OK"
}
'''

Response Body (Failed) :

'''
json
{
"errors" : "contact is not found"
}
'''
