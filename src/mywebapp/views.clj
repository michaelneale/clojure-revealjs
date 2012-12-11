(ns mywebapp.views
  (:use [hiccup core page element]))


(def reveal-js "
      // Full list of configuration options available here:
      // https://github.com/hakimel/reveal.js#configuration
      Reveal.initialize({
        controls: true,
        progress: true,
        history: true,

        theme: Reveal.getQueryHash().theme, // available themes are in /css/theme
        transition: Reveal.getQueryHash().transition || 'default', // default/cube/page/concave/zoom/linear/none

        // Optional libraries used to extend on reveal.js
        dependencies: [
          { src: 'lib/js/classList.js', condition: function() { return !document.body.classList; } },
          { src: 'plugin/markdown/showdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
          { src: 'plugin/markdown/markdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
          { src: 'plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } },
          { src: 'plugin/zoom-js/zoom.js', async: true, condition: function() { return !!document.body.classList; } },
          { src: 'plugin/notes/notes.js', async: true, condition: function() { return !!document.body.classList; } }
        ]
      });

")

(defn template [& body]
  (html5
   [:head
    [:title "Cloudbees clickstart"]
    
    [:link {:rel "stylesheet" :href "/css/reveal.css" }]
    [:link {:rel "stylesheet" :href "/css/theme/default.css" :id "theme" }]
    [:link {:rel "stylesheet" :href "/lib/css/zenburn.css" }]]

   [:body 
    
    [:div.container
     body]
     (include-js "/lib/js/head.min.js")
     (include-js "js/reveal.min.js")
     (javascript-tag reveal-js)]))




   

