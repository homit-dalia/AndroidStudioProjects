import folium
import pandas

map = folium.Map(location = [38, -99], zoom_start=5)

data = pandas.read_csv("Volcanoes_USA.txt")

latitude= list(data["LAT"])
longitude= list(data["LON"])
name = list(data["NAME"])
status = list(data["STATUS"])
elevation = list(data["ELEV"])

fg = folium.FeatureGroup(name ="My Map")

for lat , lon, nam, stat, elev in zip(latitude, longitude, name, status, elevation):
    elev = float(elev)
    if elev < 2000.0:
        fg.add_child(folium.Marker(location = [lat, lon], popup = nam + " - " + stat + "\n" + str(elev) + " m" , icon = folium.Icon(color='green')))
    elif elev >=2000.0 and elev < 3000.0:
        fg.add_child(folium.Marker(location = [lat, lon], popup = nam + " - " + stat + "\n" + str(elev) + " m" , icon = folium.Icon(color='orange')))
    else:
        fg.add_child(folium.Marker(location = [lat, lon], popup = nam + " - " + stat + "\n" + str(elev) + " m" , icon = folium.Icon(color='red')))

map.add_child(fg)

map.save("Map2.html")
