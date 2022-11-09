import folium
import pandas

map = folium.Map(location = [38, -99], zoom_start=3)

data = pandas.read_csv("Volcanoes_USA.txt")


latitude= list(data["LAT"])
longitude= list(data["LON"])
name = list(data["NAME"])
status = list(data["STATUS"])
elevation = list(data["ELEV"])

def color(eleva):
        eleva = float(eleva)
        if eleva < 2000.0:
            return 'green'
        elif eleva >=2000.0 and elev < 3000.0:
            return 'orange'
        else:
            return 'red'

fgv = folium.FeatureGroup(name ="Volcanoes")

for lat , lon, nam, stat, elev in zip(latitude, longitude, name, status, elevation):
    fgv.add_child(folium.CircleMarker(location = [lat, lon], radius = 6, popup = nam + " - " + stat + "\n" + str(elev)
     + " m" ,color = 'black', fill_color= color(elev), fill_opacity= 0.7))

fgp = folium.FeatureGroup(name ="Population")

fgp.add_child(folium.GeoJson(data=open('world.json', 'r', encoding = 'utf-8-sig').read(), style_function= lambda x: {'fillColor': 'green' if x['properties']['POP2005'] < 10000000 else 'orange' if x['properties']['POP2005'] < 20000000 else 'red'}))

map.add_child(fgv)
map.add_child(fgp)
map.add_child(folium.LayerControl())

map.save("Map.html")
