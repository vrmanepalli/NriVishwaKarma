package com.nrivishwakarma.databaseclasses;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.nrivishwakarma.utilities.Interests;

public class DBInterests {
	
	public Interests getInterests(String email) throws Exception{
			Interests inter = new Interests();
			Connection con=DBConnection.getInstance().getConnection();
			Statement stm=(Statement) con.createStatement();
			ResultSet rs = (ResultSet) stm.executeQuery
					("select * from interests where email = '"+email+"'");
			while(rs.next() ){
				inter.setArt(rs.getString("art"));
				inter.setAuto(rs.getString("auto"));
				inter.setBookbiography(rs.getString("bookbiography"));
				inter.setBookclassic(rs.getString("bookclassic"));
				inter.setBookcomedy(rs.getString("bookcomedy"));
				inter.setBookdetective(rs.getString("bookdetective"));
				inter.setBookfantasy(rs.getString("bookfantasy"));
				inter.setBookhorror(rs.getString("bookhorror"));
				inter.setBooklovestory(rs.getString("booklovestory"));
				inter.setBookscience(rs.getString("bookscience"));
				inter.setBooktragedy(rs.getString("booktragedy"));
				inter.setCollecting(rs.getString("collecting"));
				inter.setComputer(rs.getString("computer"));
				inter.setCookery(rs.getString("cookery"));
				inter.setEmail(email);
				inter.setHaunting(rs.getString("haunting"));
				inter.setMovieadventure(rs.getString("movieadventure"));
				inter.setMoviearthouse(rs.getString("moviearthouse"));
				inter.setMoviecomedy(rs.getString("moviecomedy"));
				inter.setMoviedetective(rs.getString("moviedetective"));
				inter.setMoviedrama(rs.getString("moviedrama"));
				inter.setMoviefantasy(rs.getString("moviefantasy"));
				inter.setMoviehistorical(rs.getString("moviehistorical"));
				inter.setMoviehorror(rs.getString("moviehorror"));
				inter.setMoviemusical(rs.getString("moviemusical"));
				inter.setMoviescience(rs.getString("moviescience"));
				inter.setMoviesitcom(rs.getString("moviesitcom"));
				inter.setMoviethriller(rs.getString("moviethriller"));
				inter.setMovietvseries(rs.getString("movietvseries"));
				inter.setMoviewestern(rs.getString("moviewestern"));
				inter.setMusicclassic(rs.getString("musicclassic"));
				inter.setMusiccountry(rs.getString("musiccountry"));
				inter.setMusicdance(rs.getString("musicdance"));
				inter.setMusicdisco(rs.getString("musicdisco"));
				inter.setMusichip_hop(rs.getString("musichip_hop"));
				inter.setMusicjass(rs.getString("musicjass"));
				inter.setMusiclatino(rs.getString("musiclatino"));
				inter.setMusicpank(rs.getString("musicpank"));
				inter.setMusicpop(rs.getString("musicpop"));
				inter.setMusicretro(rs.getString("musicretro"));
				inter.setMusicrnb(rs.getString("musicrnb"));
				inter.setMusicrock(rs.getString("musicrock"));
				inter.setMusicrocknroll(rs.getString("musicrocknroll"));
				inter.setMusicsastriya_sangeet(rs.getString("musicsastriya_sangeet"));
				inter.setMusicshanson(rs.getString("musicshanson"));
				inter.setMusictechno(rs.getString("musictechno"));
				inter.setNeedlework(rs.getString("needlework"));
				inter.setPcgames(rs.getString("pcgames"));
				inter.setPhoto(rs.getString("photo"));
				inter.setScience(rs.getString("science"));
				inter.setSportbaseball(rs.getString("sportbaseball"));
				inter.setSportbasketball(rs.getString("sportbasketball"));
				inter.setSportbicycle(rs.getString("sportbicycle"));
				inter.setSportbowling(rs.getString("sportbowling"));
				inter.setSportboxing(rs.getString("sportboxing"));
				inter.setSportboxing(rs.getString("sportboxing"));
				inter.setSportdiving(rs.getString("sportdiving"));
				inter.setSportfitness(rs.getString("sportfitness"));
				inter.setSportfootball(rs.getString("sportfootball"));
				inter.setSporthockey(rs.getString("sporthockey"));
				inter.setSportjudo(rs.getString("sportjudo"));
				inter.setSportkickboxing(rs.getString("sportkickboxing"));
				inter.setSportroller_skates(rs.getString("sportroller_skates"));
				inter.setSportrunning(rs.getString("sportrunning"));
				inter.setSportskates(rs.getString("sportskates"));
				inter.setSportskilling(rs.getString("sportskilling"));
				inter.setSportsnowboard(rs.getString("sportsnowboard"));
				inter.setSportsoccer(rs.getString("sportsoccer"));
				inter.setSportsurfing(rs.getString("sportsurfing"));
				inter.setSportswimming(rs.getString("sportswimming"));
				inter.setSporttennis(rs.getString("sporttennis"));
				inter.setSportvolyball(rs.getString("sportvolyball"));
				inter.setSportyoga(rs.getString("sportyoga"));
				inter.setTheater(rs.getString("theater"));
				inter.setTravel(rs.getString("travel"));
						  
			}//while
		return inter;
	}//method to get all interests of user by email
	
	public void updateInterests(Interests inter) throws Exception{
		Connection con=DBConnection.getInstance().getConnection();
		System.out.println("From updateinterest.class inter: "+inter);
		PreparedStatement pstm = con.prepareStatement("update interests set photo=?, collecting=?, needlework=?, pcgames=?, travel=?,"
				+ " computer=?,       cookery=?,            art=?, auto=?,    theater=?,         haunting=?,        science=?,        bookclassic=?,   bookcomedy=?, bookfantasy=?,"
				+ " bookscience=?,    booktragedy=?,        booklovestory=?,  bookhorror=?,      bookbiography=?,   bookdetective=?,  moviearthouse=?, moviecomedy=?,"
				+ " movieadventure=?, moviemusical=?,       movietvseries=?,  moviehistorical=?, moviefantasy=?,    moviedetective=?, moviedrama=?, "
				+ "moviescience=?,    moviethriller=?,      moviehorror=?,    moviewestern=?,    moviesitcom=?,     musicpop=?,       musicpank=?,     musicdance=?, "
				+ "musicshanson=?,    musicrnb=?,           musicdisco=?,     musiclatino=?,     musiccountry=?,    musichip_hop=?,   musicjass=?,     musicretro=?, "
				+ "musictechno=?,     musicclassic=?,       musicrocknroll=?, musicsastriya_sangeet=?, musicrock=?, sportrunning=?,   sporthockey=?, "
				+ "sportdiving=?,     sportjudo=?,          sportsoccer=?,    sportfitness=?,    sportbowling=?,    sportskates=?,    sportfootball=?, sportswimming=?, "
				+ "sportsurfing=?,    sportroller_skates=?, sportvolyball=?,  sportbicycle=?,    sportyoga=?,       sportskilling=?,  sportbaseball=?, "
				+ "sporttennis=?,     sportboxing=?,        sportbasketball=?,sportsnowboard=?, sportkickboxing=?   where email='"+inter.getEmail()+"'");
		pstm.setString(1, inter.getPhoto());				pstm.setString(2, inter.getCollecting());		pstm.setString(3, inter.getNeedlework());
		pstm.setString(4, inter.getPcgames());				pstm.setString(5, inter.getTravel());			pstm.setString(6, inter.getComputer());
		pstm.setString(7, inter.getCookery());				pstm.setString(8, inter.getArt());				pstm.setString(9, inter.getAuto());
		pstm.setString(10, inter.getTheater());				pstm.setString(11, inter.getHaunting());		pstm.setString(12, inter.getScience());     pstm.setString(13, inter.getBookclassic());
		pstm.setString(14, inter.getBookcomedy());			pstm.setString(15, inter.getBookfantasy());		pstm.setString(16, inter.getBookscience());
		pstm.setString(17, inter.getBooktragedy());			pstm.setString(18, inter.getBooklovestory());	pstm.setString(19, inter.getBookhorror());
		pstm.setString(20, inter.getBookbiography());		pstm.setString(21, inter.getBookdetective());	pstm.setString(22, inter.getMoviearthouse());
		pstm.setString(23, inter.getMoviecomedy());			pstm.setString(24, inter.getMovieadventure());	pstm.setString(25, inter.getMoviemusical());
		pstm.setString(26, inter.getMovietvseries());		pstm.setString(27, inter.getMoviehistorical());	pstm.setString(28, inter.getMoviefantasy());
		pstm.setString(29, inter.getMoviedetective());		pstm.setString(30, inter.getMoviedrama());		pstm.setString(31, inter.getMoviescience());
		pstm.setString(32, inter.getMoviethriller());		pstm.setString(33, inter.getMoviehorror());		pstm.setString(34, inter.getMoviewestern());
		pstm.setString(35, inter.getMoviesitcom());			pstm.setString(36, inter.getMusicpop());		pstm.setString(37, inter.getMusicpank());
		pstm.setString(38, inter.getMusicdance());			pstm.setString(39, inter.getMusicshanson());	pstm.setString(40, inter.getMusicrnb());
		pstm.setString(41, inter.getMusicdisco());			pstm.setString(42, inter.getMusiclatino());		pstm.setString(43, inter.getMusiccountry());
		pstm.setString(44, inter.getMusichip_hop());		pstm.setString(45, inter.getMusicjass());		pstm.setString(46, inter.getMusicretro());
		pstm.setString(47, inter.getMusictechno());			pstm.setString(48, inter.getMusicclassic());	pstm.setString(49, inter.getMusicrocknroll());
		pstm.setString(50, inter.getMusicsastriya_sangeet());pstm.setString(51, inter.getMusicrock());		pstm.setString(52, inter.getSportrunning());
		pstm.setString(53, inter.getSporthockey());			pstm.setString(54, inter.getSportdiving());		pstm.setString(55, inter.getSportjudo());
		pstm.setString(56, inter.getSportsoccer());			pstm.setString(57, inter.getSportfitness());	pstm.setString(58, inter.getSportbowling());
		pstm.setString(59, inter.getSportskates());			pstm.setString(60, inter.getSportfootball());	pstm.setString(61, inter.getSportswimming());
		pstm.setString(62, inter.getSportsurfing());		pstm.setString(63, inter.getSportroller_skates());pstm.setString(64, inter.getSportvolyball());
		pstm.setString(65, inter.getSportbicycle()); 		pstm.setString(66, inter.getSportyoga());		pstm.setString(67, inter.getSportskilling());
		pstm.setString(68, inter.getSportbaseball());		pstm.setString(69, inter.getSporttennis());		pstm.setString(70, inter.getSportboxing());
		pstm.setString(71, inter.getSportbasketball());		pstm.setString(72, inter.getSportsnowboard());	pstm.setString(73, inter.getSportkickboxing());
		pstm.execute();
	}//method for update interests of user
}
