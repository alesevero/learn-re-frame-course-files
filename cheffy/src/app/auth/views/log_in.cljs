(ns app.auth.views.log-in
  (:require [app.components.page-nav :refer [page-nav]]
            [app.components.form-group :refer [form-group]]
            [reagent.core :as r]
            ["@smooth-ui/core-sc" :refer [Row Col Box Button]]
            [re-frame.core :as rf]))

(defn log-in
  []
  (let [initial-values {:email "" :password ""}
        values (r/atom initial-values)]
    (fn []
      [:> Row {:justify-content "center"}
       [:> Col {:xs 12 :sm 6}
        [page-nav {:center "Log In"}]
        [form-group {:id :email
                     :type "email"
                     :values values
                     :label "Email"}]
        [form-group {:id :password
                     :type "password"
                     :values values
                     :label "Password"}]
        [:> Box {:display "flex"
                 :justify-content "space-between"}
         [:> Box {:py 1
                  :pyr 2}
          [:a {:href "#sign-up"
               :on-click #(rf/dispatch [:set-active-nav :sign-up])}
           "New to Cheffy? Create an account!"]]
         [:> Box
          [:> Button {:on-click #(rf/dispatch [:log-in @values])}
           "Log in"]]]]])))
