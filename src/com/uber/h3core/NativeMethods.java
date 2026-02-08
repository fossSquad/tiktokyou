package com.uber.h3core;

import com.uber.h3core.util.LatLng;
import java.util.ArrayList;
import java.util.List;

public final class NativeMethods {
    public native boolean areNeighborCells(long j, long j2);

    public native double cellAreaKm2(long j);

    public native double cellAreaM2(long j);

    public native double cellAreaRads2(long j);

    public native int cellToBoundary(long j, double[] dArr);

    public native long cellToCenterChild(long j, int i);

    public native long cellToChildPos(long j, int i);

    public native void cellToChildren(long j, int i, long[] jArr);

    public native long cellToChildrenSize(long j, int i);

    public native void cellToLatLng(long j, double[] dArr);

    public native void cellToLocalIj(long j, long j2, int[] iArr);

    public native long cellToVertex(long j, int i);

    public native void cellToVertexes(long j, long[] jArr);

    public native long cellsToDirectedEdge(long j, long j2);

    public native void cellsToLinkedMultiPolygon(long[] jArr, ArrayList<List<List<LatLng>>> arrayList);

    public native long childPosToCell(long j, long j2, int i);

    public native void compactCells(long[] jArr, long[] jArr2);

    public native int directedEdgeToBoundary(long j, double[] dArr);

    public native void directedEdgeToCells(long j, long[] jArr);

    public native double edgeLengthKm(long j);

    public native double edgeLengthM(long j);

    public native double edgeLengthRads(long j);

    public native int getBaseCellNumber(long j);

    public native long getDirectedEdgeDestination(long j);

    public native long getDirectedEdgeOrigin(long j);

    public native double getHexagonAreaAvgKm2(int i);

    public native double getHexagonAreaAvgM2(int i);

    public native double getHexagonEdgeLengthAvgKm(int i);

    public native double getHexagonEdgeLengthAvgM(int i);

    public native void getIcosahedronFaces(long j, int[] iArr);

    public native long getNumCells(int i);

    public native void getPentagons(int i, long[] jArr);

    public native void getRes0Cells(long[] jArr);

    public native double greatCircleDistanceKm(double d, double d2, double d3, double d4);

    public native double greatCircleDistanceM(double d, double d2, double d3, double d4);

    public native double greatCircleDistanceRads(double d, double d2, double d3, double d4);

    public native void gridDisk(long j, int i, long[] jArr);

    public native void gridDiskDistances(long j, int i, long[] jArr, int[] iArr);

    public native void gridDiskUnsafe(long j, int i, long[] jArr);

    public native long gridDistance(long j, long j2);

    public native void gridPathCells(long j, long j2, long[] jArr);

    public native long gridPathCellsSize(long j, long j2);

    public native void gridRingUnsafe(long j, int i, long[] jArr);

    public native boolean isPentagon(long j);

    public native boolean isValidCell(long j);

    public native boolean isValidDirectedEdge(long j);

    public native boolean isValidVertex(long j);

    public native long latLngToCell(double d, double d2, int i);

    public native long localIjToCell(long j, int i, int i2);

    public native int maxFaceCount(long j);

    public native long maxGridDiskSize(int i);

    public native long maxPolygonToCellsSize(double[] dArr, int[] iArr, double[] dArr2, int i, int i2);

    public native void originToDirectedEdges(long j, long[] jArr);

    public native void polygonToCells(double[] dArr, int[] iArr, double[] dArr2, int i, int i2, long[] jArr);

    public native void uncompactCells(long[] jArr, int i, long[] jArr2);

    public native long uncompactCellsSize(long[] jArr, int i);

    public native void vertexToLatLng(long j, double[] dArr);
}
