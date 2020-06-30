(ns leiningen.new.gen2d
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "gen2d"))

(defn gen2d
  "Minimal clojure2d template for my generative art"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' gen2d project.")
    (->files data
             ["README.md" (render "README.md.template" data)]
             ["src/{{sanitized}}/main.clj" (render "main.clj.template" data)]
             ["project.clj" (render "project.clj.template" data)]
             "out/")))
