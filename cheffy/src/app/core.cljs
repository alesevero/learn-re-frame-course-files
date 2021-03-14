(ns app.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.db]
            ;;  -- profile --
            [app.auth.views.profile :refer [profile]]
            [app.auth.views.sign-up :refer [sign-up]]
            [app.auth.views.log-in :refer [log-in]]
            ;;  -- become-a-chef --
            [app.become-a-chef.views.become-a-chef :refer [become-a-chef]]
            ;;  -- inboxes --
            [app.inbox.views.inboxes :refer [inboxes]]
            ;;  -- nav --
            [app.nav.views.nav :refer [nav]]
            ;;  -- recipes --
            [app.recipes.views.recipes :refer [recipes]]
            [app.nav.events]
            [app.nav.subs]
            [app.theme :refer [cheffy-theme]]
            ["@smooth-ui/core-sc" :refer [Normalize ThemeProvider Grid Row Col]]))

(defn pages
  [page-name]
  (case page-name
    :profile [profile]
    :become-a-chef [become-a-chef]
    :inboxes [inboxes]
    :recipes [recipes]
    :sign-up [sign-up]
    :log-in [log-in]
    [recipes]))

(defn app
  []
  (let [active-nav @(rf/subscribe [:active-nav])]
    [:<>
     [:> Normalize]
     [:> ThemeProvider {:theme cheffy-theme}
      [:> Grid {:fluid false}
       [:> Row
        [:> Col
         [nav]
         [pages active-nav]]]]]]))

(defn ^:dev/after-load start
  []
  (rf/dispatch-sync [:initialize-db])
  (r/render [app]
            (.getElementById js/document "app")))

(defn ^:export init
  []
  (start))
