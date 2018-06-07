package gui.mapa;

import com.sothawo.mapjfx.Coordinate;
import com.sothawo.mapjfx.MapView;
import com.sothawo.mapjfx.WMSParam;

public class Mapa {

	private static WMSParam wmsParam = new WMSParam()
			.setUrl("http://geonode.wfp.org:80/geoserver/ows")
			.addParam("layers", "geonode:admin_2_gaul_2015");
	private MapView mapa = null;
	private static final Coordinate chubut = new Coordinate(-44.038186, -68.705483);
	
	public MapView crearMapa() {
		mapa = new MapView();
		mapa.setAnimationDuration(500);
		mapa.setCenter(chubut);
		mapa.setZoom(6);
		mapa.setWMSParam(wmsParam);
		
//		final OfflineCache offlineCache = mapa.getOfflineCache();
//		offlineCache.setCacheDirectory(FileSystems.getDefault().getPath("tmp"));
//		offlineCache.setActive(false);
//		offlineCache.setNoCacheFilters(Collections.singletonList(".*\\.sothawo\\.com/.*"));
		
//		mapa.initializedProperty().addListener((observable, oldValue, newValue) -> {
//			if (newValue) {
//				mapa.setCenter(chubut);
//				mapa.setZoom(7);
//			}
//		});
		
		return mapa;
	}
	
	public void iniciarMapa() {
		mapa.initialize();		
	}

}
