Charles's Test
--------------
<p>Hope I've done this right I didn't add a customer to the account entity and DTO as this produces a circular dependency. If you wanted a many to many relationship you would have to produce a link table but it says 1..* which I assume is one to many.</p>
<p>The Ids don't have a generate on them so you have to supply the integer, I say integer because the findById specifies this so the types have to match.</p>
<p>I changed both saves to copy back the Id if it was to be generated and I added the post.</p>
<p>http://localhost:8080/customer/customerDTO</p>
<p>has been checked with postman:</p>
<p>{ 
    "customerId": 1,
    "forename" : "Charlie",
    "surname" : "Swires",
    "dateOfBirth" : "2021-12-19T13:22:12.982+00:00",
    "accountDTOS":[
        {
        "accountId": 1,
        "accountNumber": 1234567890
        },
        {
        "accountId": 2,
        "accountNumber": 1234567891
        }
    ]
}</p>
<p> Also the accounts are a List not a Set I assumed code done already was nearly correct.</p>
<p> All fixed.</p>
