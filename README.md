#  Ever wanted to do your reveal.js presentations as a clojure webapp? 

[![Git](https://app.soluble.cloud/api/v1/public/badges/76e2f56d-8d9f-4f57-9d92-6454e4b6100e.svg?orgId=451115019187)](https://app.soluble.cloud/repos/details/github.com/michaelneale/clojure-revealjs?orgId=451115019187)  

Me neither - but here we are. 

Demo: http://osdcclojure.playground.cloudbees.net

Look in slides.clj - reasonable "DSL" for writing presentations.




# Running it locally:
lein ring server

(you can make changes and refresh)

# To deploy it for all the world to see (on cloudbees here):
lein cloudbees deploy

Edit slides.clj to, um, edit your slides. 

Uses hiccup and reveal.js
