# survey
# Getting Started

### POST

[http://localhost:5000/api/addVote](http://localhost:5000/api/addVote)
````
{
"productId": 1,
"surveyId":2,
"vote":5
}
````

### GET
Get list of product id=1
[http://localhost:5000/api/getProductVote/1](http://localhost:5000/api/getProductVote/1)

### GET
Get all list
[http://localhost:5000/api/getAllList](http://localhost:5000/api/getAllList)

### Database
H2 memorial db
[http://localhost:5000/h2/](http://localhost:5000/h2/)
Tables:
Survey,
SurveyVote

