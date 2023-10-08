#Address API Spec

##Create Address
Enpoint :  POST /api/contacts/{idContact}/address

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

'''json
{
"street" : "jalan yanga mana",
"city" : "padang",
"province" : "provinsi",
"postal code" : "12345"
}
'''

Response Bodyn (Success):

'''json
{
"data" :
{
"id": "randomstring",
"street" : "jalan yanga mana",
"city" : "padang",
"province" : "provinsi",
"postal code" : "12345"
}
}
'''

Response Body (Failed);
'''json
"errors" : "Contacts is not found"

'''



##Update Address

Enpoint :  PUT /api/contacts/{idContact}/address/{idAddress}

equest Header :
- X-API-TOKEN : Token (Mandatory)

Request Body :

'''json
{
"street" : "jalan yanga mana",
"city" : "padang",
"province" : "provinsi",
"postal code" : "12345"
}
'''

Response Bodyn (Success):

'''json
{
"data" :
{
"id": "randomstring",
"street" : "jalan yanga mana",
"city" : "padang",
"province" : "provinsi",
"postal code" : "12345"
}
}
'''

Response Body (Failed);
'''json
"errors" : "Contacts is not found"

'''


##Get Addres

Enpoint :  GET /api/contacts/{idContact}/addresses/{idAddress}

equest Header :
- X-API-TOKEN : Token (Mandatory)

Response Bodyn (Success):

'''json
{
"data" :
{
"id": "randomstring",
"street" : "jalan yanga mana",
"city" : "padang",
"province" : "provinsi",
"postal code" : "12345"
}
}
'''

Response Body (Failed);
'''json
"errors" : "adress is not found"

'''



##Remove Address

Enpoint :  DELETE /api/contacts/{idContacts}/addresses/{idAddress}

equest Header :
- X-API-TOKEN : Token (Mandatory)

Response Bodyn (Success):

'''json
{
"data" : "OK"

}
'''

Response Body (Failed);
'''json
"errors" : "adress is not found"

'''

## List Address
Endpoint : GET /api/contacts/{idContacts}/addresses

equest Header :
- X-API-TOKEN : Token (Mandatory)



Response Bodyn (Success):

'''json
{
"data" :
{
"id": "randomstring",
"street" : "jalan yanga mana",
"city" : "padang",
"province" : "provinsi",
"postal code" : "12345"
}
}
'''

Response Body (Failed);
'''json
"errors" : "Contacts is not found"

'''