import folium
import pandas

map = folium.Map(location = [38, -99], zoom_start=5)

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

fg = folium.FeatureGroup(name ="My Map")

for lat , lon, nam, stat, elev in zip(latitude, longitude, name, status, elevation):
    fg.add_child(folium.CircleMarker(size= 100, location = [lat, lon], popup = nam + " - " + stat + "\n" + str(elev) + " m" , icon = folium.Icon(color=color(elev))))

map.add_child(fg)

map.save("Tryout1.html")
