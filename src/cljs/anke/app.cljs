(ns anke.app
  (:require [reagent.core :as reagent :refer [atom]]))

(def images
  {:profile "/images/anke-11182065_10153226799909277_7717425233651471422_n.jpg"
   :rohan "/images/rohan-10672244_10153206563629277_9179385808807987757_n.jpg"
   :flowers "/images/flowers-1010595_10152671673674277_1526557493224940580_n.jpg"
   :olifant "/images/diere-11152357_10206655683816329_8431945855882811367_n.jpg"
   :cats "http://media1.giphy.com/media/brRWBSKoc9ueI/giphy.gif"
   :frida "/images/anke1-10444796_10152852922969277_929896057518254277_n.jpg"
   :quote "/images/anke3-179165_10151581531304277_649118127_n.jpg"
   :dick "/images/anke5-11088339_10202878232277428_1168572289750589482_n.jpg"
   :onsie "/images/anke6-10647222_10155051980595585_2274770794015725782_n.jpg"
   :family "/images/anke7-10835182_10203441915995288_9001907036833433941_o.jpg"
   :schmodel "/images/anke4403831_10150545129099277_1478382286_n.jpg"})

(defn img
  "Got tired of typing {:src ...}"
  [src props]
  [:img
   (merge props
     {:src src})])

(defn anke-image
  "Helper function that pulls image url out of images and then calls img."
  [key class]
  (img (get images key)
    {:width "100%" :class (or class "img-rounded")}))

(defn link
  "Helper for links."
  [href & body]
  [:a {:href href} body])

(defn media [title url img-src & body]
  [:div.media
   [:div.media-left
    (link link (img img-src {:class "img-rounded"}))]
   [:div.media-body
    [:h4.media-heading title]
    body]])

(defn heading [& body]
  [:h2.text-center
   body])

(defn section [n title & body]
  [:div {:class (str "col-xs-" n)}
   [:h2 title]
   body])

(defn parent-component []
  [:div#page-top.index
   [:div.container

    [:div.row
     [:div.col-md-3
      [:div
       [:h1.text-center.lowercase "Anke"]
       (anke-image :profile "img-circle")
       [:h3 "About Me"]
       [:p.lead
        "I'm your host, Anke. Narrative Client Service Graduate at Publicis Machine."]
       [:p.lead
        "Ek is 'n Durban hoenertjie."]
       (anke-image :schmodel)]]

     [:div.col-md-9
      [:h1.page-header.text-center "Dinge wat ek Smaak"]

      [:div.row
       (section 4 "Doodle"
         (anke-image :frida nil))

       (section 8 "Miaaw miaauw"
         (anke-image :cats nil))]
      
      [:div.row
       (section 12 "Nature"
         (img "http://media.giphy.com/media/7cTJ3gWVsoC08/giphy.gif" {:width "100%"}))]

      [:div.row
       (section 8 "Blomme"
         (anke-image :flowers))
       (section 4 "Dick"
         (anke-image :dick))]

      [:div.row
       (section 6 "Diere"
         (anke-image :olifant))
       (section 6 "Onsies"
         (anke-image :onsie))]

      [:div.row
       (section 4 "Rohan"
         (anke-image :rohan))

       (section 8 "Familie"
         (anke-image :family))]]]

    [:footer
     [:hr]
     [:p.text-center "Much love, P. Happy birthday!"]]]])

(defn init []
  (reagent/render-component [parent-component]
    (.getElementById js/document "container")))
