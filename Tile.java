package chess.board;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import chess.pieces.Piece;

public abstract class Tile {
	
	protected final int titleCoordinate;
	
	private static final Map<Integer, EmptyTile> EMPTY_TILES_CAHCHE = createAllPossibleEmptyTiles();
	
	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles(){
		
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		
		for(int i = 0; i < 64; i++) {
			emptyTileMap.put(i, new EmptyTile(i));
		}
		Collections.unmodifiableMap(emptyTileMap);
		return ImmutableMap.copyOf(emptyTileMap);
	}
	
	public static Tile createTile(final int tileCoordinate, final Piece piece) {
		return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CAHCHE.get(tileCoordinate);
	}
	
	Tile(int titleCoordinate) {
		this.titleCoordinate = titleCoordinate;
	}

	public abstract boolean isTileOccupied();
	public abstract Piece getPiece();
	
	
	public static final class EmptyTile extends Tile {
		EmptyTile(int coordinate) {
			super(coordinate);
		}
		

		@Override
		public boolean isTileOccupied() {
			return false;
		}
		
		@Override
		public Piece getPiece() {
			return null;
		}
	}
	
	public static final class OccupiedTile extends Tile {
		
		Piece pieceOnTile;
		
		OccupiedTile(int titleCoordinate, Piece pieceOnTile) {
			super(titleCoordinate);
			this.pieceOnTile = pieceOnTile;
		}
		
		@Override
	public boolean isTileOccupied() {
			return true;
			
		}
		
		@Override
	public Piece getPiece() {
			return this.pieceOnTile;
		}
	}
}
