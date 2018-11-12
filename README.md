# Trainee
Service for some sensor

Some description:
- To display last 10 inputs I use Mustache template system. Unfourtantely it doesn't support format output, thats why we have a lot of numbers after comma.
- To define cities I use Google Location API. When setting coordinates it's get near city. Free version let me use only 1 request a day. But I want to show how cities filter work. For that I attach some screenshots. Now some code (class: GetLocation, line: 26-32) is commented out to correct display inputs.

  Screenshots:
  
  userPage
  ![mainTest](https://avatars.mds.yandex.net/get-pdb/1515467/3c577f82-9dc8-4b3b-8d27-5d474ac46d14/s1200)
  
  test1
  ![test1](https://avatars.mds.yandex.net/get-pdb/1551019/32239015-55c3-4300-a948-86d07ecdfe60/s1200)
  
  test2
  ![test2](https://avatars.mds.yandex.net/get-pdb/1566774/2d368b4c-4d2d-4abd-bc5a-ea4741384c49/s1200)