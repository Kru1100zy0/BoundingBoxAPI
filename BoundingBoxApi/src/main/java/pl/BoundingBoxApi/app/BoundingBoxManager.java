package pl.BoundingBoxApi.app;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BoundingBoxManager {

    List<BoundingBox> boundingBoxesList = new LinkedList<BoundingBox>();

    private final Vector2 imgSize;
    private final Vector2 minBoundingBoxSize;

    public BoundingBoxManager(@Value("${workspace.image.width}")float imgX,
                              @Value("${workspace.image.height}")float imgY,
                              @Value("${workspace.boundingBox.minWidth}")float minBoundingBoxWidth,
                              @Value("${workspace.boundingBox.minHeight}")float minBoundingBoxHeight) {

        this.imgSize = new Vector2(imgX,imgY);
        this.minBoundingBoxSize = new Vector2(minBoundingBoxWidth,minBoundingBoxHeight);
    }

    public void AddBoundingBox(BoundingBox boundingBox)
    {
        if(BoundingBoxMeetsSizeRequirements(boundingBox))
        {
            boundingBoxesList.add(boundingBox);
        }
    }

    public void RemoveBoundingBox(String id)
    {
        boundingBoxesList.removeIf(item -> item.getId().equals(id));
    }

    public void EditBoundingBox(BoundingBox boundingBox)
    {
        if(BoundingBoxMeetsSizeRequirements(boundingBox))
        {
            boundingBoxesList.stream().filter(item -> item.getId() == boundingBox.getId()).findAny().ifPresent(item -> item = new BoundingBox(boundingBox));
        }
    }

    public BoundingBox GetBoundingBoxById(String id)
    {
        return boundingBoxesList.stream().filter(item -> item.equals(id)).findFirst().get();
    }


    public List<BoundingBox> getBoundingBoxesList() {
        return boundingBoxesList;
    }

    private boolean BoundingBoxMeetsSizeRequirements(@NotNull BoundingBox boundingBox)
    {
        //if Bounding box is bigger than minimal requirements
        if(boundingBox.getWidth() >= minBoundingBoxSize.getX() && boundingBox.getHeight() >= minBoundingBoxSize.getY())
        {
            //if bounding box fits in the img
            return boundingBox.getFirstPoint().getX() >= 0 && boundingBox.getFirstPoint().getX() <= imgSize.getX() &&
                    boundingBox.getFirstPoint().getY() >= 0 && boundingBox.getFirstPoint().getY() <= imgSize.getY();
        }
        return false;
    }

}
