(ns mywebapp.slides
    (:use [hiccup core page element] mywebapp.views))


(defn big-slide [title body]
            [:section [:h1 title] 
                [:p body]])

(defn big-slide-soothe [title body]
            [:section {:data-state "soothe"} [:h1 title] 
                [:p body]])

(defn big-slide-alert [title body]
            [:section {:data-state "alert"} [:h1 title] 
                [:p body]])


(defn big-slide-list [title & items]
        [:section [:h1 title]
          (map (fn [x] [:p x]) items)])

(defn slide [& items]
        [:section [:h ""]  (map (fn [x] [:p x]) items)])




(defn big-slide-bullets [title & items]
        [:section [:h1 title]
          (unordered-list items)])


(defn less-big-slide [title body]
            [:section [:h3 title] 
                [:p body]])

(defn link [url] [:a {:href url} url])




(defn code-block [code]
    (str 
        "<pre><code contenteditable style=\"font-size: 18px; margin-top: 20px;\">" 
        code "</code></pre>"))    
    

(defn slides-page []
  (template   
   [:div {:class "reveal"}
   [:div {:class "slides"}
    (big-slide-list 
        "Clojure - another run at lisp"
          "@michaelneale" (link "developer.cloudbees.com") (link "https://github.com/michaelneale/clojure-osdc-2012")
          (link "http://osdcclojure.playground.cloudbees.net")                        
          (image "/clojure_logo.png"))                         
    (slide (image "/cloudbees.png") 
        (link "http://developer.cloudbees.com") (link "http://twitter.com/michaelneale"))

    (big-slide-bullets "What is Clojure" "Another take on lisp" "Lisp 1"
        (link "http://stackoverflow.com/questions/4578574") 
        "A lisp JVM/CLR and JS targeting (LLVM too?)")
    (big-slide-alert "I n c e p t i o n" (image "/presentation.png"))

    (big-slide-list "What is LISP?" 
        "A toolkit for building a language to solve your problems (a DSL)"
        "The language the universe was written in")

    (big-slide-soothe (image "/lisp_god.png") "")
    (big-slide-alert (image "/mccarthy.png") "")

    (big-slide-list "STAY CALM" "don't let the parens put you off" 
        "S-expressions are like the AST directly"
         "S-expressions allow macros to actually work"
         "Homoiconic - data is functions is data"
         )

    (big-slide-soothe "" (code-block "(function-name [arguments] do stuff)\n;; comments
        \n;; clojure extensions:\n
        ;; maps {:key value :key2 value2}\n
        ;; lists [1 2 3]"))
    (big-slide-list "learning" 
        "Took me a long weekend to feel almost comfortable"
        "MIT SICP lectures - excellent")

    (big-slide-list "where is clojure used" 
            "Anywhere JVM can run (server side)"
            "Big data apps (eg flightcaster backend)"
            "Web apps"
            "in the browser (clojurescript)"
            "At CloudBees")

    (slide "A project (using Leiningen)" (image "/project_setup.png"))

    (slide "Consuming a http service" (image "/http_api.png"))

    (slide "Loading all the repos in a github org" (image "/github.png"))

    (big-slide-alert "my god it's full of parentheses" (image "/fullofstars.png"))

    (big-slide "REPL" (image "/repl.png"))

    (big-slide "filtering" (image "/filtering.png"))

    (big-slide "rest http" (image "/http_rest.png"))

    (big-slide-soothe "Immutability" "Persistent/immutable data structures, lists, maps")

    (big-slide-list "Immutability" "Changes to persistent datastructures create new instances"
                "No mutation" "Efficiency in implementation"
                "Get -> easier concurrency, correctness")

    (big-slide-alert "No-OO" (unordered-list ["This is not object oriented"
            "Functions the unit of composition (namespaces?)"
            "Easier to reason over"
            "Less places for state to hide"
            ]))

    (big-slide-list "Unlearning OO" "OO is not a fundamental particle"
        "More harm than good?"
        "Best concepts of OO - message passing, reuse:"
        "Work better without mainstream OO"
        "Does have records, types and protocols")

    (big-slide-list "Side benefit" 
        "Less frameworks, more libraries"
        "Libraries are functions brought into scope and used"
        "frameworks change your programming model"
        "libraries compose, frameworks don't")

    (big-slide-alert "Mutability"
        "(ok maybe I lied a bit)")

    (big-slide-list "Mutants" 
            "Atoms - sync un-coordinated changes"
            "Agents - async un-coordinated changes"
            "Refs - sync co-ord multiple val changes (STM)"
            "Vars - local to a thread - no contention")

    (big-slide-list "STM - (refs)" "Software Transactional Memory"
        "Apply changes to lots of things"
        "All succeed, or all fail, retry"
        "works by compare and swap - pass a function to mutate")
    (big-slide-soothe "Agents" (image "/agents.png"))
    (big-slide-soothe "mutable things" (code-block "(@thing) ;; get current value\n
;;set via (send) or (swap!) - in all cases a function passed"))

    (big-slide-list "use recursion" 
        (image "/recurse.png")
        "Gotcha:"
        (code-block "(recur ...) ;; Tail call elimination :("))

    (big-slide-list "Clojure brings..." 
        "Lots of existing libraries (JVM)"
        "Friendly repo - clojars"
        (link "http://clojars.org")
        "high quality native libraries" )

    (big-slide-list "Where you can run clojure"
        "Target JVM: server side mostly"
        "ClojureScript: via google clojure -> js in browser"
        (link "https://github.com/clojure/clojure-clr")
        "LLVM experiments")

    (big-slide-list "On JVM" "JVM most popular target" "ClojureScript rising fast (popular with people unfamiliar with the JVM)"
                        "currently JVM familiarity helps - a bit"
                        "Many community members not familiar with JVM")

    (big-slide-soothe "ClojureScript" (unordered-list[
        "Popular in its own right"
        "For those who are only interested in JS side" 
        (link "https://github.com/clojure/clojurescript")]))

    (big-slide-list "What have I used it for"
        "Monitoring apps"
        "Github api consumption"
        "Small micro-services (long running and background)")

    (big-slide-soothe "How I structure"
        (unordered-list ["One parent namespace"
                        "separate API from core logic namespaces (files), views etc"
                        "all in one dir (separate test dir)"
                        "deliver as webapp (via ring)"
                        (link "https://github.com/michaelneale/pingtown")
                        "Run on a PaaS"]))




    (big-slide-alert "building and deploying"
        "build with Leiningen and CI")

    (less-big-slide "Jenkins CI" (image "/jenkins.png"))

    (less-big-slide "Jenkins CI config" (image "/jenkins_config.png"))

    (less-big-slide "Build deployment unit" (code-block "lein ring uberjar (etc)"))

    (big-slide-list "Running" 
        (slide (code-block "lein ring server\n-or-\n$ java -jar app.jar"))
        (slide (big-slide-soothe "Web apps" "embedded container, or not !")))
    

    (big-slide-list "Deploying" 
            (code-block "lein cloudbees deploy")
             (code-block "lein beanstalk deploy"))

    (big-slide-list "Continuous deployment (briefly)"
            "CI: src -> lein test -> deploy")

    (big-slide-list "Easy start"
        (slide (image "/clickstarts.png"))
        (slide (image "/clickstart.png"))
        (slide (image "/clojure_app.png")))

    (big-slide-list "Editors" 
        "Emacs (most popular with swank/slime type setup)"
        "Sumlime Text (my favourite)"
        "but anything really (all major IDEs)")

    (big-slide-soothe "Where to get started?"
        (unordered-list ["install lein"
                        (link "https://github.com/technomancy/leiningen")
                        (code-block "lein new project-name")
                        (code-block "lein repl")
                        (link "http://developer.cloudbees.com")]))



    (big-slide-alert "Thank you !" 
        (unordered-list ["Q&A",
                        "Please to reach out to me:" 
                        (link "@michaelneale")                        
                        (link "http://osdcclojure.playground.cloudbees.net")                        
                        (link "https://cloudbees-community.github.com")]))        

    ]]))
















