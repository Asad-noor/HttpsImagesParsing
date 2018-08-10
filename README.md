About this app
-
### Design an app where a list of users will be displayed in the app coming from a backend server using REST API

#### Features: 

1. Display a list of users.
2. Each cell or item will contain 4 information: 
       - First name 
       - Last name 
       - Mobile number 
       - Profile image 


#### Specifications: 

 - Use standard material UI.
 - List of users can be found using the API, GET: http://dropbox.sandbox2000.com/intrvw/users.json 
 - Each of the user has a **photo** attribute with an integer ID. You can get the profile picture from this URL, 
https://randomuser.me/api/portraits/women/{PHOTO_ID}.jpg
For exmaple, https://randomuser.me/api/portraits/women/41.jpg
    - Note that, if the user **gender** attribute is **male** use this URL, 
https://randomuser.me/api/portraits/men/{PHOTO_ID}.jpg
    - if **female** then use this URL, 
https://randomuser.me/api/portraits/women/{PHOTO_ID}.jpg
 - Feature wise you don't need to implement anything else other than what is specified. 
 - Don't worry if the app isn't 100% functional, write high level classes/methods so that we can understand you are on right track.

#### Sample User JSON data,

```
{
      "id": 1719844608,
      "firstName": "Johnnie",
      "lastName": "Jonathan",
      "phones": {
        "home": "524-789-3468",
        "mobile": "691-772-7392"
      },
      "email": [
        "krtxlhamd@itc.com",
        "ljyaaojkr@itc.org"
      ],
      "dateOfBirth": "1999-05-19T00:00:00.000Z",
      "registered": true,
      "gender": "female",
      "photo": 41
}
