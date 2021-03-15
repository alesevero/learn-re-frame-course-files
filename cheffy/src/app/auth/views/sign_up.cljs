(ns app.auth.views.sign-up
  (:require [app.components.page-nav :refer [page-nav]]
            [app.components.form-group :refer [form-group]]
            [reagent.core :as r]
            ["@smooth-ui/core-sc" :refer [Row Col Box Button]]
            [re-frame.core :as rf]))

(defn sign-up
  []
  (let [initial-values {:first-name "" :last-name "" :email "" :password ""}
        values (r/atom initial-values)]
    (fn []
      [:> Row {:justify-content "center"}
       [:> Col {:xs 12 :sm 6}
        [page-nav {:center "Sign Up"}]
        [form-group {:id :first-name
                     :type "test"
                     :values values
                     :label "First Name"}]
        [form-group {:id :last-name
                     :type "text"
                     :values values
                     :label "Last Name"}]
        [form-group {:id :email
                     :type "email"
                     :values values
                     :label "Email"}]
        [form-group {:id :password
                     :type "password"
                     :values values
                     :label "Password"}]
        [:> Box {:display "flex"
                 :justify-content "flex-end"}
         [:> Button {:on-click #(rf/dispatch [:sign-up @values])}
          "Sign Up"]]]])))
