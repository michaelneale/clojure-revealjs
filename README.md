#  Ever wanted to do your reveal.js presentations as a clojure webapp? 

Me neither - but here we are. 

Look in slides.clj - reasonable "DSL" for writing presentations.


# Running it locally:
lein ring server

(you can make changes and refresh)

# To deploy it for all the world to see:
lein cloudbees deploy

Edit slides.clj to, um, edit your slides. 

Uses hiccup and reveal.js