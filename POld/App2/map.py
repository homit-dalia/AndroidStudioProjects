import folium
map = folium.Map(location = [21.19, 72.81])

fg = folium.FeatureGroup(name ="My Markers")
fg.add_child(folium.Marker(location = [21.19, 72.81], popup = "Famous", icon = folium.Icon(color='green')))

map.save("Map.html")
