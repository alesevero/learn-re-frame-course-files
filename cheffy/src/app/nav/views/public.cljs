(ns app.nav.views.public
  (:require [app.nav.views.nav-item :refer [nav-item]]
            [re-frame.core :as rf]
            ["@smooth-ui/core-sc" :refer [Box]]))

(defn public
  []
  (let [active-nav @(rf/subscribe [:active-nav])
        nav-items [{:id :recipes
                    :name "Recipes"
                    :href "#recipes"
                    :dispatch #(rf/dispatch [:set-active-nav :recipes])}
                   {:id :become-a-chef
                    :name "Become A Chef"
                    :href "#become-a-chef"
                    :dispatch #(rf/dispatch [:set-active-nav :become-a-chef])}
                   {:id :sign-up
                    :name "Sign Up"
                    :href "#sign-up"
                    :dispatch #(rf/dispatch [:set-active-nav :sign-up])}
                   {:id :log-in
                    :name "Log In"
                    :href "#log-in"
                    :dispatch #(rf/dispatch [:set-active-nav :log-in])}]]
    [:> Box {:display "flex"
             :justify-content "flex-end"
             :py 1}
     (for [{:keys [id name dispatch href]} nav-items]
       [nav-item {:key id
                  :id id
                  :name name
                  :dispatch dispatch
                  :href href
                  :active-nav active-nav}])]))
