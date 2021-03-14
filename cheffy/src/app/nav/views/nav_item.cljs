(ns app.nav.views.nav-item
  (:require ["@smooth-ui/core-sc" :refer [Box]]))

(defn nav-item
  [{:keys [id href name dispatch active-nav]}]
  [:> Box {:key id
           :as "a"
           :href href
           :ml 2
           :pb 10
           :on-click dispatch
           :border-bottom (when (= active-nav id) "2px solid #102A43")}
   name])
